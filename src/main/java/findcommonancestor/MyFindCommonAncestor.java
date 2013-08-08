package findcommonancestor;

import java.util.*;

public class MyFindCommonAncestor implements FindCommonAncestor {
    public String findCommmonAncestor(String[] commitHashes, String[][] parentHashes,
                                      String commitHash1, String commitHash2) {

        Map<String, List<LinkedHashSet<String>>> graph;
        graph = createCommitHashesGraph(commitHashes, parentHashes, commitHash1, commitHash2);

        return mostRecentCommonAncestor(graph, commitHash1, commitHash2);
    }

    private static Map<String, List<LinkedHashSet<String>>> createCommitHashesGraph(String[] commitHashes,
                                                                                    String[][] parentHashes,
                                                                                    String commitHash1,
                                                                                    String commitHash2) {
        int N = commitHashes.length;
        Map<String, List<LinkedHashSet<String>>> graph = new HashMap<String, List<LinkedHashSet<String>>>(N);

        boolean commitHash1Found = false;
        boolean commitHash2Found = false;
        int i = N - 1;
        while (i >= 0 && !(commitHash1Found && commitHash2Found)) {
            String commit = commitHashes[i];
            if (commitHash1.equals(commit)) commitHash1Found = true;
            if (commitHash2.equals(commit)) commitHash2Found = true;

            String[] parents = parentHashes[i];
            List<LinkedHashSet<String>> commitListTrails = new LinkedList<LinkedHashSet<String>>();

            LinkedHashSet<String> commitListTrail;
            if (parents == null) {
                commitListTrail = new LinkedHashSet<String>();
                commitListTrail.add(commit);

                commitListTrails.add(commitListTrail);
            } else {
                for (String parent : parents) {
                    List<LinkedHashSet<String>> parentListTrails = graph.get(parent);
                    for (LinkedHashSet<String> parentListTrail : parentListTrails) {
                        commitListTrail = new LinkedHashSet<String>(parentListTrail);
                        commitListTrail.add(commit);
                        commitListTrails.add(commitListTrail);
                    }
                }
            }

            graph.put(commit, commitListTrails);
            i--;
        }
        return graph;
    }

    private static String mostRecentCommonAncestor(Map<String, List<LinkedHashSet<String>>> graph,
                                                   String commitHash1, String commitHash2) {

        String ancestorFound = null;
        int maxCommitCount = Integer.MAX_VALUE;
        for (LinkedHashSet<String> commmitHash1Trail : graph.get(commitHash1)) {
            String[] ancestors = new String[commmitHash1Trail.size()];
            commmitHash1Trail.toArray(ancestors);

            for (LinkedHashSet<String> commmitHash2Trail : graph.get(commitHash2)) {
                int j = ancestors.length - 1;
                while (j >= 0) {
                    String ancestor = ancestors[j];
                    if (commmitHash2Trail.contains(ancestor)) {
                        int commitCount = ancestors.length - j;
                        if (commitCount < maxCommitCount) {
                            ancestorFound = ancestor;
                            maxCommitCount = commitCount;
                        }
                    }
                    j--;
                }
            }
        }

        return ancestorFound;
    }

}
