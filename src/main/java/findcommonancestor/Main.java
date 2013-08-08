package findcommonancestor;

public class Main {

    public static void main(String[] args) {
        String[] commits = {"G", "F", "E", "D", "C", "B", "A"};
        String[][] parents ={{"F","D"},{"E"}, {"B"}, {"C"}, {"B"}, {"A"}, null};
        String commit1 = "D";
        String commit2 = "F";

        System.out.println("Expected -B- " + new MyFindCommonAncestor().findCommmonAncestor(commits, parents, commit1, commit2));
        System.out.println("------------------------------------------------");
    }

}
