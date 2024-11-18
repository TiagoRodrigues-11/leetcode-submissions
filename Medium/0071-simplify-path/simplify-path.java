class Solution {
    public String simplifyPath(String path) {
        String[] simplifiedPathList = path.split("/");
        Stack<String> stack = new Stack<>();

        for(String str: simplifiedPathList) {
            if (!str.isEmpty()) {
                if (str.equals("..")) {
                    if(!stack.isEmpty()) {
                        stack.pop();
                    }
                    continue;
                }
                if (str.equals(".")) {
                    continue;
                }
                stack.push(str);
            }
        }

        String simplifiedPath = new String();

        while(!stack.isEmpty()) {
            simplifiedPath = "/" + stack.pop() + simplifiedPath;
        } 
        
        if (simplifiedPath.isEmpty()) {
            simplifiedPath = "/";
        }

        return simplifiedPath;
    } 
}