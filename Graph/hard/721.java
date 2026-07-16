import java.util.*;

class Solution {

    class DSU {
        int[] parent;

        DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++)
                parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa != pb)
                parent[pb] = pa;
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        int n = accounts.size();
        DSU dsu = new DSU(n);

        Map<String, Integer> emailToIndex = new HashMap<>();

        // 1️⃣ Union accounts sharing same email
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if (emailToIndex.containsKey(email)) {
                    dsu.union(i, emailToIndex.get(email));
                } else {
                    emailToIndex.put(email, i);
                }
            }
        }

        // 2️⃣ Group emails by root parent
        Map<Integer, TreeSet<String>> groups = new HashMap<>();

        for (String email : emailToIndex.keySet()) {
            int root = dsu.find(emailToIndex.get(email));
            groups.computeIfAbsent(root, k -> new TreeSet<>()).add(email);
        }

        // 3️⃣ Build result
        List<List<String>> result = new ArrayList<>();

        for (int root : groups.keySet()) {
            List<String> merged = new ArrayList<>();
            merged.add(accounts.get(root).get(0)); // name
            merged.addAll(groups.get(root));
            result.add(merged);
        }

        return result;
    }
}
