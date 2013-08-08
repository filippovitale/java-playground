package findcommonancestor;

import java.util.*;

public class MyFindCommonAncestor implements FindCommonAncestor {
    public String findCommmonAncestor(String[] commitHashes, String[][] parentHashes,
                                      String commitHash1, String commitHash2) {

        int N = commitHashes.length;
        Map<String, LinkedHashSet<String>> graph = new HashMap<String, LinkedHashSet<String>>(N);

        boolean commitHash1Found = false;
        boolean commitHash2Found = false;
        int i = N - 1;
        while (i >= 0 && !(commitHash1Found && commitHash2Found)) {
            String commit = commitHashes[i];

            if (commitHash1.equals(commitHashes[i])) commitHash1Found = true;
            if (commitHash2.equals(commitHashes[i])) commitHash2Found = true;


            String[] parents = parentHashes[i];
            LinkedHashSet<String> commitListTrail;
            if (parents == null) {
                commitListTrail = new LinkedHashSet<String>();
            } else {
                //for (String parent : parents){
                //System.out.println("parent " + parent);
                //}
                // TODO assuming only one parent
                commitListTrail = new LinkedHashSet<String>(graph.get(parents[0]));
            }
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
