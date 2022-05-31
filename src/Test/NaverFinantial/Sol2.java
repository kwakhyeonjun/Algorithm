package Test.NaverFinantial;

import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Sol2 {
    public static void main(String[] args) {
        Sol2 sol = new Sol2();

        String[] cities = {"a","b","c"};
        String[] roads = {"a b 1","a c 1","b c 1"};
        String[] cars = {"a 100 10","b 300 20","c 50 4"};
        String[] customers = {"a b 100","a b 30","c a 250"};


        String[] solve = sol.solution(cities, roads, cars, customers);
        for(String s : solve) {
            System.out.println(s);
        }
    }

    /**
     * 최소비용
     * 최대 무게와 1km당 요금이 정해져있음.
     * 같은 이사 업체의 차량의 경우, 최대 적재 무게가 더 큰 차량의 1km당 이용 요금이 더 비쌈.
     * 이사비용 : 차량이 이동한 거리 x 1km당 이용 요금
     * 이동거리 : 최단거리로 이동한 거리
     * 최대 적재 무게 >= 고객의 짐 무게
     * @author Kwak Hyeonjun
     * @param cities 도시 목록
     * @param roads 도로 정보
     * @param cars 차량 정보
     * @param customers 각 고객들의 출발 도시, 도착 도시, 짐의 무게
     * @return 가장 저렴하게 이용할 수 있는 이사 업체가 속한 도시 이름
     */
    int[][] map;
    String[] cities;
    public String[] solution(String[] cities, String[] roads, String[] cars, String[] customers) {
        String[] answer = new String[customers.length];

        // 지도 채우기
        map = new int[cities.length][cities.length];
        this.cities = cities;
        for(int i = 0; i < roads.length; i++) {
            StringTokenizer st = new StringTokenizer(roads[i]);
            String fromCity = st.nextToken();
            String toCity = st.nextToken();
            String dist = st.nextToken();
            int fromIndex = -1, toIndex = -1;
            for(int j = 0; j < cities.length; j++) {
                if(cities[j].equals(fromCity)){
                    fromIndex = j;
                }
                if(cities[j].equals(toCity)){
                    toIndex = j;
                }
            }
            map[fromIndex][toIndex] = Integer.parseInt(dist);
        }

        // 차량 파싱
        ArrayList<Car> carList = new ArrayList<>(cities.length);

        for(int i = 0; i < cars.length; i++) {
            StringTokenizer st = new StringTokenizer(cars[i]);
            String city = st.nextToken();
            int weight = Integer.parseInt(st.nextToken());
            int charge = Integer.parseInt(st.nextToken());
            int cityIndex = -1;
            for(int j = 0 ; j < cities.length; j++) {
                if(cities[j].equals(city)){
                    cityIndex = j;
                    break;
                }
            }
            carList.add(new Car(cityIndex, weight, charge));
        }

        // 고객 파싱
        ArrayList<Customer> customerList = new ArrayList<>(customers.length);

        for(int i = 0; i < customers.length; i++) {
            StringTokenizer st = new StringTokenizer(customers[i]);
            String fromCity = st.nextToken();
            String toCity = st.nextToken();
            int weight = Integer.parseInt(st.nextToken());
            int fromIndex = -1, toIndex = -1;
            for(int j = 0; j < cities.length; j++) {
                if(cities[j].equals(fromCity)){
                    fromIndex = j;
                }
                if(cities[j].equals(toCity)){
                    toIndex = j;
                }
            }
            customerList.add(new Customer(fromIndex, toIndex, weight));
        }

        // 가장 저렴한 것 찾기
        ArrayList<String> answerList = new ArrayList<>();
        for(Customer customer : customerList) {
            int MIN = Integer.MAX_VALUE;
            Car minCar = new Car();

            // 모든 차량에 대해 순회
            for(Car car : carList) {
                int cost = 0;
                // 1. 현재 위지로 오기
                cost += move(car.city, customer.fromCity);

                // 2. 목적지로 이동
                cost += move(customer.fromCity, customer.toCity);

                // 3. 최소비용 확인
                if(MIN > cost) {
                    minCar = car;
                    MIN = cost;
                }
            }

            // 최소비용 도시 저장
            answerList.add(cities[minCar.city]);
        }
        for(int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }

    private boolean[] isVisited;
    private int move(int fromCity, int toCity) {
        isVisited = new boolean[cities.length];
        Stack<int[]> stack = new Stack<>();
        stack.add(new int[]{fromCity, 0});
        isVisited[fromCity] = true;

        while(!stack.isEmpty()) {
            int[] cur = stack.pop();
            for(int i = 0; i < map.length; i++) {
                if(!isVisited[i] && map[cur[0]][i] > 0) {
                    if(i == toCity) {
                        return cur[1] + map[cur[0]][i];
                    }
                    stack.push(new int[]{i, cur[1] + map[cur[0]][i]});
                }
            }
        }
        return -1;
    }


    private class Car{
        int city;
        int weight;
        int charge;

        Car(){}

        Car(int city, int weight, int charge) {
            this.city = city;
            this.weight = weight;
            this.charge = charge;
        }
    }

    private class Customer {
        int fromCity;
        int toCity;
        int weight;

        public Customer(int fromCity, int toCity, int weight) {
            this.fromCity = fromCity;
            this.toCity = toCity;
            this.weight = weight;
        }
    }
}
