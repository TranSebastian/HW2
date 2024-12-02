import java.util.Arrays;

public class Question5 {
    public static void main(String[] args) 
    {
        System.out.println("====================Input 1========================");
        System.out.println("Output: " + Arrays.toString(minVaccineTime(createGraph("2-7, 3-4, 2-8, 1-6, 1-3, 2-3, 6-9, 4-5", 9))));
        System.out.println("====================Input 2========================");
        System.out.println("Output: " + Arrays.toString(minVaccineTime(createGraph("1-4, 2-6, 5-8, 2-5, 1-2, 7-5, 3-8, 10-6", 10))));
    }

    // creates an adjacency matrix of the village.
    public static int [] [] createGraph (String edges, int numNodes)
    {
        int [] [] graph = new int[numNodes][numNodes];
        String [] temp = edges.split(", ");
        System.out.println("Number of villages: " + numNodes);
        System.out.println("Roads: " + edges);

        for (String edge : temp)
        {
            int in = Integer.parseInt(edge.substring(0, edge.indexOf("-")));
            int out = Integer.parseInt(edge.substring(edge.indexOf("-")+1));

            graph[in-1][out-1] = Math.max(in, out);
            graph[out-1][in-1] = Math.max(in, out);
        }

        return graph;
    }

    // finds the min time for each of the villages
    public static int [] minVaccineTime (int [] [] graph)
    {
        int [] nodes = new int[graph.length];

        for (int i = 0; i < nodes.length; i++)
        {
            nodes[i] = minDistance(graph, i, new boolean[graph.length]);
        }

        return nodes;
    }

    // recursive algorithm that finds the smallest distance it has with another node that is prime.
    public static int minDistance (int [] [] graph, int node, boolean [] nodesSearched)
    {
        nodesSearched[node] = true; //marked the current viewed node as searched to prevent going backwards.

        //base case, is prime
        if (isPrime(node+1))
        {
            return 0;
        }

        int min = Integer.MAX_VALUE;

        // loooop through the outgoing connections of the currenrtly viewed node.
        for (int i = 0; i < graph[node].length; i++)
        {
            int total = 0;  //keeps track of the path total, for each node connection
    
            if (graph[node][i] != 0 && nodesSearched[i] == false)
            {
                int jank = minDistance(graph, i, nodesSearched);
                total = graph[node][i] + jank;

                if (jank != -1 && total < min)  // checks for a dead end
                {
                    min = total;
                }
            }
        }

        if (min == Integer.MAX_VALUE)
        {
            return -1;
        }
        return min;
    }

    public static boolean isPrime (int num)
    {
        if (num == 1)
        {
            return false;
        }

        int i = 2;

        while (i < num)
        {
            if (num % i == 0)
            {
                return false;
            }
            i++;
        }

        return true;
    }
}

