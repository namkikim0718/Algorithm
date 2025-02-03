import java.util.*;

class Solution {
    
    static Map<String, List<String>> graph = new HashMap<>();
    static int ticketCnt;
    static List<String> route = new ArrayList<>();
    static boolean isFound = false;
    
    static void dfs(String now, List<String> nowArr) {
        
        if (nowArr.size() == ticketCnt+1) {
            route.addAll(nowArr);
            isFound = true;
            return;
        }
        
        if (!graph.containsKey(now)) return;
        
        List<String> destinations = graph.get(now);
        
        for (int i = 0; i < destinations.size(); i++) {
            String dest = destinations.remove(i);
            nowArr.add(dest);
            
            dfs(dest, nowArr);
            
            nowArr.remove(nowArr.size()-1);
            destinations.add(i, dest);    
            
            if (isFound) return;
        }
    }
    
    public List<String> solution(String[][] tickets) {
        
        ticketCnt = tickets.length;
        
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[1]);
        });
        
        for (String[] ticket : tickets) {
            graph.putIfAbsent(ticket[0], new ArrayList<>());
            graph.get(ticket[0]).add(ticket[1]);
        }
        
        List<String> start = new ArrayList<>();
        start.add("ICN");
        dfs("ICN", start);
        
        return route;
    }
}