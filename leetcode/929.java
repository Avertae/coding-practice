class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String s : emails) {
            StringBuilder local = new StringBuilder(s.substring(0, s.indexOf('@')));
            StringBuilder domain = new StringBuilder(s.substring(s.indexOf('@')));
            if (local.indexOf("+") >= 0)
                local.delete(local.indexOf("+"), local.length());
            while (local.indexOf(".") >= 0)
                local.replace(local.indexOf("."), local.indexOf(".") + 1, "");
            String email = local.append(domain).toString();
            set.add(email);
        }
        System.out.println(set);
        return set.size();
    }
}