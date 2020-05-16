import java.util.*;

class PeaSoupAndPancakes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int numOfRestaurants = sc.nextInt();
        Restaurant[] restaurants = new Restaurant[numOfRestaurants];

        for(int a = 0; a < numOfRestaurants; a++) {
            int numOfMenuItems = sc.nextInt();

            sc.nextLine();

            String restaurantName = sc.nextLine();

            restaurants[a] = new Restaurant(restaurantName, numOfMenuItems);

            for(int b = 0; b < numOfMenuItems; b++) {
                String itemName = sc.nextLine();
                restaurants[a].setItem(b, itemName);
            }
        }
        
        sc.close();

        System.out.println(foodLookup(restaurants));
    }

    public static String foodLookup(Restaurant[] restaurants) {
        for(int a = 0; a < restaurants.length; a++) {
            String[] currentMenu = restaurants[a].getMenu();
            boolean hasPeaSoup = false;
            boolean hasPancakes = false;
            
            for(int b = 0; b < currentMenu.length && (!hasPeaSoup || !hasPancakes); b++) {
                if(currentMenu[b].equals("pea soup")) {
                    hasPeaSoup = true;
                }
                if(currentMenu[b].equals("pancakes")) {
                    hasPancakes = true;
                }
            }

            boolean hasBoth = hasPeaSoup && hasPancakes;

            if(hasBoth) {
                return restaurants[a].getName();
            }
        }

        return "Anywhere is fine i guess";
    }
}
