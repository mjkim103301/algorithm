package level2;

public class summer_winter_coding_2018_skillTree {
    public static void main(String[] args) {
        Solution_skillTree sol = new Solution_skillTree();
        String skill = "CBD";
        skill="CBA";
       // String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        String[] skill_trees={"ABC", "CBA"};

        int answer = sol.solution(skill, skill_trees);
        System.out.println(answer);
    }
}
class Solution_skillTree {

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int skillLen=skill_trees.length;
        int skillNum=0;
        int skillTreeIndex=0;
        boolean isValid=true;

        for(int i=0;i<skillLen;i++){
            int treeSize=skill_trees[i].length();
            isValid=true;
            skillNum=0;
            for(int j=0;j<treeSize;j++){
                skillTreeIndex=skill.indexOf(skill_trees[i].charAt(j));
                if(skillTreeIndex==-1){
                    continue;
                }else if(skillNum==skillTreeIndex){
                    skillNum ++;
                }else{
                    isValid=false;
                    break;
                }
            }
            if(isValid==true){
                answer++;
            }
        }
        return answer;
    }
}
