package findcommonancestor;

import java.util.*;

public class MyFindCommonAncestor implements FindCommonAncestor {
    public String findCommmonAncestor(String[] commitHashes, String[][] parentHashes,
                                      String commitHash1, String commitHash2) {

        int N = commitHashes.length;
        Map<String, LinkedHashSet<String>> graph = new HashMap<String, LinkedHashSet<String>>(N);

        String rootCommit = commitHashes[N - 1];

        LinkedHashSet<String> rootListTrail = new LinkedHashSet<String>();
        rootListTrail.add(rootCommit);

        graph.put(rootCommit, rootListTrail);

        boolean commitHash1Found = false;
        boolean commitHash2Found = false;
        int i = N - 2; // TODO try integrate into the main loop
        while (i >= 0 && !(commitHash1Found && commitHash2Found)) {
            String commit = commitHashes[i];
            String[] parents = parentHashes[i];

            if (commitHash1.equals(commitHashes[i])) commitHash1Found = true;
            if (commitHash2.equals(commitHashes[i])) commitHash2Found = true;

            //for (String parent : parents){
            //System.out.println("parent " + parent);
            //}
            // TODO assuming only one parent
            String parent = parents[0];
            LinkedHashSet<String> commitListTrail = new LinkedHashSet<String>(graph.get(parent));
            commitListTrail.add(commit);
            graph.put(commit, commitListTrail);

            System.out.println("[" + i + "]=" + commit + " " + commitListTrail);
            i--;
        }

        System.out.println("-------------------------------------------------");

        LinkedHashSet<String> commmitHash1Trail = graph.get(commitHash1);
        String[] ancestors = new String[commmitHash1Trail.size()];
        commmitHash1Trail.toArray(ancestors);

        LinkedHashSet<String> commmitHash2Trail = graph.get(commitHash2);
        int j = ancestors.length - 1;
        while (j >= 0) {
            String ancestor = ancestors[j];
            if (commmitHash2Trail.contains(ancestor)) {
                return ancestor;
            }
            j--;
        }

        return null;
    }

}
