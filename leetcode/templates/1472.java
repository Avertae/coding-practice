class BrowserHistory {

    Stack<String> fw = new Stack<>();
    Stack<String> bk = new Stack<>();
    String currentUrl;

    public BrowserHistory(String homepage) {
        currentUrl = homepage;
    }
    
    public void visit(String url) {
        bk.push(currentUrl);
        currentUrl = url;
        fw.clear();
    }
    
    public String back(int steps) {
        for (int i = 0; i < steps; i++) 
            if (bk.size() > 0) {
                fw.push(currentUrl);
                currentUrl = bk.pop();
            } else 
                break;
        
        return currentUrl;
    }
    
    public String forward(int steps) {
        for (int i = 0; i < steps; i++) 
            if (fw.size() > 0) {
                bk.push(currentUrl);
                currentUrl = fw.pop();
            }
        return currentUrl;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */