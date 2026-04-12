// import java.util.*;
class Solution {
    public String foreignDictionary(String[] words) {
      int n = words.length;
      //bfs - topological sort
      List<List<Integer>> adj = new ArrayList<>();
        for (int i=0;i<26;i++)
        {
            adj.add(new ArrayList<>());
        }
      //adjacency matrix
      boolean[] present = new boolean[26];

        
    for (String w : words) {
        for (char c : w.toCharArray()) {
            present[c - 'a'] = true;
        }
    }
      
      for (int i=0;i<n-1;i++)
      {
        String s1 = words[i];
        String s2 = words[i+1];
        boolean f = false;
        for (int j=0;j<Math.min(s1.length(),s2.length());j++)
        {
            if (s1.charAt(j)!=s2.charAt(j))
            {
                adj.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');
                f = true;
                break;
            }
        }

        if (!f && s1.length()>s2.length())
        {
            return ""; // case of s2 is a prefix of s1
        }
      }
      int[] indegree = new int[26];
      for (int i=0;i<26;i++)
      {
        for (int it:adj.get(i))
        {
            indegree[it]++;
        }
      }

      Queue<Integer> q = new ArrayDeque<>();
      for (int i=0;i<26;i++)
      {
        if (present[i] && indegree[i]==0)
        {
            q.add(i);
        }
      }
      StringBuilder sb = new StringBuilder();
      while(!q.isEmpty())
      {
        int node = q.poll();
        sb.append((char)(node+'a'));
        for (int it:adj.get(node))
        {
            indegree[it]--;
            if (indegree[it]==0)
            {
                q.add(it);
            }
        }
      }
      int cnt=0;
      for (boolean i:present)
      {
        if (i==true)
        {
            cnt++;
        }
      }
      if (sb.length()!=cnt)
        return "";
      return sb.toString();
    }
}
