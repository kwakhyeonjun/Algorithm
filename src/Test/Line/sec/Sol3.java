package Test.Line.sec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Sol3 {

    public static void main(String[] args) {

        int num_teams = 3;
        String[] remote_tasks = {"development","marketing","hometask"};
        String[] office_tasks = {"recruitment","education","officetask"};
        String[] employees = {"1 development hometask","1 recruitment marketing","2 hometask","2 development marketing hometask","3 marketing","3 officetask","3 development"};
        System.out.println(Arrays.toString(solution(num_teams, remote_tasks, office_tasks, employees)));
    }


    /**
     * 업무 : 재택 가능 업무, 재택 불가능 업무
     * 어떤 사원의 업무가 재택 가능한 업무만 있다면 재택 근무 대상자임.
     * 팀마다 한명은 출근해야함.
     * 팀 모두가 재택 근무 대상자라면 가장 빠른 사원번호가 출근함.
     *
     */
    public static int[] solution(int num_teams, String[] remote_tasks, String[] office_tasks, String[] employees) {
        List<Integer> answerList = new ArrayList<>();

        ArrayList<Employee>[] team = new ArrayList[num_teams];
        for(int i = 0; i < num_teams; i++) {
            team[i] = new ArrayList<>();
        }

        for(int i = 0; i < employees.length; i++) {
            StringTokenizer st = new StringTokenizer(employees[i]);
            int tNum = Integer.parseInt(st.nextToken());
            String task = st.nextToken() + " ";
            while(st.hasMoreTokens()){
                task += st.nextToken() + " ";
            }

            boolean isRemote = true;

            for(String remote_task : remote_tasks) {
                task = task.replace(remote_task, "");
            }

            task = task.replace(" ", "");

            if(!task.isEmpty()) isRemote = false;

            team[tNum-1].add(new Employee(i+1, isRemote));
        }

        boolean[] officeMember = new boolean[employees.length + 1];

        for(ArrayList<Employee> member : team) {
            boolean isAllRemote = true;
            for(Employee employee : member) {
                if(!employee.isRemote) {
                    isAllRemote = false;
                    officeMember[employee.eNum] = true;
                }
            }
            if(isAllRemote) officeMember[member.get(0).eNum] = true;
        }

        for(int i = 1; i <= employees.length; i++) {
            if(!officeMember[i]) answerList.add(i);
        }

        int[] answer = new int[answerList.size()];
        for(int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }

    static class Employee {
        int eNum;
        boolean isRemote;

        public Employee(int eNum, boolean isRemote) {
            this.eNum = eNum;
            this.isRemote = isRemote;
        }
    }
}
