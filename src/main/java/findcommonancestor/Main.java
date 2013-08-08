package findcommonancestor;

public class Main {

    public static void main(String[] args) {
        String[] commits = {"G", "F", "E", "D", "C", "B", "A"};
        String[][] parents ={{"F","D"},{"E"}, {"B"}, {"C"}, {"B"}, {"A"}, null};

        System.out.println("------------------------------------------------");
        System.out.println("Expected -B- " + new MyFindCommonAncestor().findCommmonAncestor(commits, parents, "D", "F"));
        System.out.println("------------------------------------------------");
        System.out.println("Expected -A- " + new MyFindCommonAncestor().findCommmonAncestor(commits, parents, "A", "C"));
        System.out.println("------------------------------------------------");
        System.out.println("Expected -B- " + new MyFindCommonAncestor().findCommmonAncestor(commits, parents, "C", "E"));
        System.out.println("------------------------------------------------");
        System.out.println("Expected -E- " + new MyFindCommonAncestor().findCommmonAncestor(commits, parents, "E", "E"));
        System.out.println("------------------------------------------------");
        System.out.println("Expected -D- " + new MyFindCommonAncestor().findCommmonAncestor(commits, parents, "G", "D"));
        System.out.println("------------------------------------------------");
    }

}
