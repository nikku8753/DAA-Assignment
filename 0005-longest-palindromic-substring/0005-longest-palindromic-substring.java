class Solution {
    public String longestPalindrome(String s) {
   /*  StringBuilder sb= new StringBuilder();
     if(s.length()==2 && s.charAt(0)!=s.charAt(1)) return String.valueOf(s.charAt(0));
    int i=0;int j=s.length()-1;
    int n=s.length();*/
   /* while(i<j && n>0){
        if(s.charAt(i)!=s.charAt(j)){
            i++;j--;
        }
        n--;
        }
        String ans=s.substring(i,++j);

    
    return ans;*/
    int n=s.length();
    String res="";
    for(int i=0;i<n;i++){
        int st=i,end=i;
        while(st>=0 && end <n && s.charAt(st)==s.charAt(end)){
            st--;
            end++;
        }
        String temp=s.substring(st+1,end);
        if(temp.length()>res.length())res=temp;
        st=i;
        end=i+1;
        while(st>=0 && end<n && s.charAt(st)==s.charAt(end)){
            st--;
            end++;
        }
        temp=s.substring(st+1,end);
        if(temp.length()>res.length())res=temp;
    }
    return res;
    }
}