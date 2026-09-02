import java.util.*;

class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {

        /*
         * The manager[] array gives us the relationship in this direction:
         *
         * employee -> manager
         *
         * Example:
         * manager[3] = 1
         *
         * means:
         * Employee 1 manages Employee 3.
         *
         * But for BFS, we need the opposite direction:
         *
         * manager -> employees
         *
         * So we build a children list where:
         *
         * children[i] = all employees directly managed by employee i
         */

        List<Integer>[] children = new ArrayList[n];

        // Create an empty list for every employee.
        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }

        /*
         * Reverse the manager relationship.
         *
         * If:
         * manager[i] = x
         *
         * then employee i is a child of employee x.
         *
         * So we add i to children[x].
         *
         * The head has manager[headID] = -1,
         * so we skip the head.
         *
         * Example:
         *
         * manager = [-1, 0, 0, 1, 1, 3]
         *
         * becomes:
         *
         * children[0] = [1, 2]
         * children[1] = [3, 4]
         * children[3] = [5]
         *
         * Tree:
         *
         *          0
         *        /   \
         *       1     2
         *      / \
         *     3   4
         *    /
         *   5
         */
        for (int i = 0; i < n; i++) {

            // The head has no manager.
            if (manager[i] != -1) {
                children[manager[i]].add(i);
            }
        }

        /*
         * Now we have the company represented as a tree.
         *
         * We use BFS to start from the head and move
         * level by level through all employees.
         *
         * Each queue element stores:
         *
         * [employee, time]
         *
         * where:
         * employee = current employee
         * time     = how many minutes have passed before
         *            this employee receives the news.
         */
        Queue<int[]> queue = new LinkedList<>();

        /*
         * The head already knows the news.
         *
         * Therefore, at time = 0:
         *
         * [headID, 0]
         */
        queue.offer(new int[]{headID, 0});

        // Stores the maximum time needed to inform anyone.
        int answer = 0;

        while (!queue.isEmpty()) {

            // Get the next employee from the queue.
            int[] current = queue.poll();

            int employee = current[0];
            int currentTime = current[1];

            /*
             * currentTime tells us when this employee
             * received the news.
             *
             * We want to know when the LAST employee
             * receives the news.
             *
             * Therefore, keep the maximum time.
             */
            answer = Math.max(answer, currentTime);

            /*
             * This employee now needs informTime[employee]
             * minutes to inform all of their direct children.
             *
             * Therefore, their children will receive the news
             * at:
             *
             * currentTime + informTime[employee]
             */
            int newTime = currentTime + informTime[employee];

            /*
             * Add every direct child to the queue.
             *
             * The child receives the news at newTime.
             *
             * Later, when that child is removed from the queue,
             * it will inform its own children.
             *
             * This is how BFS automatically handles:
             *
             * Head
             *   -> Child
             *       -> Grandchild
             *           -> Great-grandchild
             *               -> ...
             */
            for (int child : children[employee]) {
                queue.offer(new int[]{child, newTime});
            }
        }

        /*
         * The employee who receives the news last determines
         * the total time required to inform the entire company.
         */
        return answer;
    }
}
