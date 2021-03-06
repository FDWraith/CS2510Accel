import tester.Tester;

/*
TEMPLATE
--------
Fields:
... this.name ...                          -- String
... this.features ...                      -- ILoFeature
Methods:
... this.totalCapacity() ...               -- int
... this.foodinessRating() ...             -- int
... this.sumRatings() ...                  -- double
... this.countRestaurants() ...            -- int
... this.restaurantInfo() ...              -- String
Methods for fields:
... this.features.totalCapacity() ...      -- int
... this.features.sumRatings() ...         -- int
... this.features.countRestaurants() ...   -- int
*/
class Place {
  String name;
  ILoFeature features;

  Place(String name, ILoFeature features) {
    this.name = name;
    this.features = features;
  }

  // counts the total available seating in all venues reachable from this place
  int totalCapacity() {
    return this.features.totalCapacity();
  }

  // return total ratings of features
  double sumRatings() {
    return features.sumRatings();
  }

  // return number of restaurants
  int countRestaurants() {
    return features.countRestaurants();
  }

  // calculates average ratings for all reachable restaurants' rating
  double foodinessRating() {
    if (this.countRestaurants() == 0) {
      return 0;
    } else {
      return this.sumRatings() / this.countRestaurants();
    }
  }

  // returns restaurants' information
  String restaurantInfo() {
    String unfixed = features.restaurantInfo();
    if (unfixed.length() == 0) {
      return unfixed;
    } else {
      return unfixed.substring(0, unfixed.length() - 2);
    }
  }
}

interface IFeature {
  int capacity();

  double getRating();

  int countRestaurant();

  String restaurantInfo();
}

/*
 * TEMPLATE: 
 * --------- 
 * Fields: 
 * ... this.name ...                 -- String 
 * ... this.type ...                 -- String 
 * ... this.averageRating ...        -- double 
 * Methods: 
 * ... this.capacity() ...           -- int 
 * ... this.getRating() ...          -- double 
 * ... this.countRestaurant() ...    -- int 
 * ... this.restaurantInfo() ...     -- String
 */
// To represent a restaurant
class Restaurant implements IFeature {
  String name;
  String type;
  double averageRating;

  Restaurant(String name, String type, double rating) {
    this.name = name;
    this.type = type;
    this.averageRating = rating;
  }

  // return capacity
  public int capacity() {
    return 0;
  }

  // return rating
  public double getRating() {
    return this.averageRating;
  }

  // return number of restaurant
  public int countRestaurant() {
    return 1;
  }

  // return information of this restaurant
  public String restaurantInfo() {
    return this.name + " (" + this.type + "), ";
  }
}

/*
 * TEMPLATE: 
 * --------- 
 * Fields: 
 * ... this.name ...                  -- String 
 * ... this.type ...                  -- String 
 * ... this.capacity ...              -- int 
 * Methods: 
 * ... this.capacity() ...            -- int
 * ... this.getRating() ...           -- double 
 * ... this.countRestaurant() ...     -- int 
 * ...this.restaurantInfo() ...       -- String
 */
// to represent a venue
class Venue implements IFeature {
  String name;
  String type;
  int capacity;

  Venue(String name, String type, int capacity) {
    this.name = name;
    this.type = type;
    this.capacity = capacity;
  }

  // count capacity
  public int capacity() {
    return this.capacity;
  }

  // return rating
  public double getRating() {
    return 0;
  }

  // return number of restaurant
  public int countRestaurant() {
    return 0;
  }

  // return the information
  public String restaurantInfo() {
    return "";
  }
}

/*
 * TEMPLATE 
 * -------- 
 * Fields: 
 * ... this.name ...                      -- String 
 * ... this.destination...                -- Place 
 * Methods: 
 * ... this.capacity() ...                -- int 
 * ... this.getRating() ...               -- double 
 * ... this.countRestaurant() ...         -- int 
 * ... this.restaurantInfo() ...          -- String 
 * Methods for fields: 
 * ... this.destination.totalCapacity() ...   -- int
 * ... this.destination.sumRatings() ...      -- double 
 * ... this.destination.countRestaunts() ...  -- int 
 * ... this.destination.restaurantInfo() ...  -- String
 */
// to represent shuttle bus
class ShuttleBus implements IFeature {
  String name;
  Place destination;

  ShuttleBus(String name, Place destination) {
    this.name = name;
    this.destination = destination;
  }

  // return capacity
  public int capacity() {
    return destination.totalCapacity();
  }

  // return rating
  public double getRating() {
    return destination.sumRatings();
  }

  // return number of restaurant
  public int countRestaurant() {
    return destination.countRestaurants();
  }

  // return information
  public String restaurantInfo() {
    return destination.restaurantInfo() + ", ";
  }
}

interface ILoFeature {
  int totalCapacity();

  double sumRatings();

  int countRestaurants();

  String restaurantInfo();
}

/*
 * TEMPLATE 
 * -------- 
 * Methods: 
 * ... this.totalCapacity() ...           -- int 
 * ... this.sumRatings() ...              -- double 
 * ... this.countRestaurants() ...        -- int 
 * ... this.restaurantInfo() ...          -- String
 */
// to represent empty list of feature
class MtLoFeature implements ILoFeature {
  public int totalCapacity() {
    return 0;
  }

  // return rating
  public double sumRatings() {
    return 0.0;
  }

  // return number of restaurant
  public int countRestaurants() {
    return 0;
  }

  //return information
  public String restaurantInfo() {
    return "";
  }
}

/*
 * TEMPLATE 
 * -------- 
 * Fields: 
 * ... this.first ...                 -- IFeature 
 * ... this.rest ...                  -- ILoFeature 
 * Methods: 
 * ... this.totalCapacity() ...       -- int 
 * ... this.sumRatings() ...          -- double 
 * ... this.countRestaurants() ...    -- int 
 * ... this.restaurantInfo() ...      -- String 
 * Methods for fields: 
 * ... this.first.capacity() ...      -- int 
 * ... this.first.getRating() ...     -- double 
 * ... this.first.getRestaurant() ... -- int 
 * ... this.rest.totalCapacity() ...  -- int 
 * ... this.rest.getRatings() ...     -- double 
 * ... this.rest.getRestaurants() ... -- int 
 * ... this.rest.restaurantInfo() ... -- String
 */
// to represent non-empty list of features
class ConsLoFeature implements ILoFeature {
  IFeature first;
  ILoFeature rest;

  ConsLoFeature(IFeature first, ILoFeature rest) {
    this.first = first;
    this.rest = rest;
  }

  // return total capacity
  public int totalCapacity() {
    return (this.first.capacity() + this.rest.totalCapacity());
  }

  // return total ratings
  public double sumRatings() {
    return this.first.getRating() + this.rest.sumRatings();
  }

  // return number of restaurants
  public int countRestaurants() {
    return this.first.countRestaurant() + this.rest.countRestaurants();
  }

  // return all restaurants' information
  public String restaurantInfo() {
    return this.first.restaurantInfo() + this.rest.restaurantInfo();
  }
}

class ExamplesPlaces {
  ILoFeature mtLoFeature = new MtLoFeature();

  IFeature tdGarden = new Venue("TD Garden", "stadium", 19580);
  IFeature mikePastry = new Restaurant("Mike's Pastry", "cannolis", 4.3);
  ILoFeature neFeatures = new ConsLoFeature(tdGarden, new ConsLoFeature(mikePastry, mtLoFeature));
  Place northEnd = new Place("North End", neFeatures);

  IFeature freshman15 = new ShuttleBus("Freshmen-15", northEnd);
  IFeature legalSea = new Restaurant("Legal Sea Foods", "seafood", 3.9);
  IFeature harvardStadium = new Venue("Harvard Stadium", "football", 30323);
  ILoFeature harvardFeatures = new ConsLoFeature(freshman15,
      new ConsLoFeature(legalSea, new ConsLoFeature(harvardStadium, mtLoFeature)));
  Place harvard = new Place("Harvard", harvardFeatures);

  IFeature northEndShuttle = new ShuttleBus("Little Italy Express", northEnd);
  IFeature auntieAnnes = new Restaurant("Auntie Anne's", "pretzels", 4.0);
  IFeature harvardShuttle = new ShuttleBus("Crimson Cruiser", harvard);
  IFeature bostonCommon = new Venue("Boston Common", "public", 150000);
  ILoFeature southStationFeatures = new ConsLoFeature(northEndShuttle,
      new ConsLoFeature(auntieAnnes,
          new ConsLoFeature(harvardShuttle, new ConsLoFeature(bostonCommon, mtLoFeature))));
  Place southStation = new Place("South Station", southStationFeatures);

  IFeature quiznos = new Restaurant("Quiznos", "sandwiches", 3.2);
  IFeature starbucks = new Restaurant("Starbucks", "coffee", 4.1);
  IFeature airportShuttle = new ShuttleBus("airport shuttle", southStation);
  ILoFeature loganAirportFeatures = new ConsLoFeature(quiznos,
      new ConsLoFeature(starbucks, new ConsLoFeature(airportShuttle, mtLoFeature)));
  Place loganAirport = new Place("Logan airport", loganAirportFeatures);

  
  // check for sumRatings()
  boolean testSumRatings(Tester t) {
    return t.checkInexact(northEnd.sumRatings(), 4.3, 0.01)
        && t.checkInexact(harvard.sumRatings(), 8.2, 0.01)
        && t.checkInexact(southStation.sumRatings(),12.2, 0.01);
  }
  
  // check for countRestaurants()
  boolean testCountRestaurants(Tester t) {
    return t.checkExpect(northEnd.countRestaurants(), 1)
        && t.checkExpect(harvard.countRestaurants(), 2)
        && t.checkExpect(loganAirport, 5);
  }

  // check for foodinessRating()
  boolean testFoodinessRating(Tester t) {
    return t.checkInexact(loganAirport.foodinessRating(), 3.967, 0.01)
        && t.checkInexact(northEnd.foodinessRating(), 4.3, 0.01)
        && t.checkInexact(harvard.foodinessRating(), 4.1, 0.01);
  }

  // check for totalCapacity
  boolean testTotalCapacity(Tester t) {
    return t.checkExpect(northEnd.totalCapacity(), 19580)
        && t.checkExpect(harvard.totalCapacity(), 49903)
        && t.checkExpect(loganAirport.totalCapacity(), 219483)// counts tdGarden twice
        && t.checkExpect(southStation.totalCapacity(), 219483);// counts tdGarden twice
  }

  // check for restaurantInfo()
  boolean testRestaurantInfo(Tester t) {
    String loganString = "Quiznos (sandwiches), Starbuckes (coffee), "
        + "Mike's Pastry (cannolis), Auntie Anne's (pretzels), "
        + "Mike's Pastry (cannolis), Legal Sea Foods (seafood)";
    return t.checkExpect(northEnd.restaurantInfo(), "Mike's Pastry (cannolis)")
        && t.checkExpect(harvard.restaurantInfo(),
            "Mike's Pastry (cannolis), Legal Sea Foods (seafood)")
        && t.checkExpect(loganAirport.restaurantInfo(), loganString);
  }

  /*
   * Describe contents of map and design data representation
   * Example Map: Place called New York City, it has two ShuttleBuses: one is the
   * 7 Train that takes you to Flushing; the other is the N Train that takes you
   * to Chinatown. Flushing (which is a Place) has a Venue called Citi Field, a
   * stadium with a capcity of 45000. It also has two ShuttleBuses, the Q26 and
   * Q17, that both take you to Fresh Meadows. Chinatown (which is a Place) has a
   * Restaurant called Wok Wok, with a rating of 4.9, and primarily serves Asian
   * cuisine. Fresh Meadows also has a Restaurant, called Apple Bees, with a
   * rating of 3.5, and primarily serves fast food.
   */
  IFeature appleBees = new Restaurant("Apple Bees", "fast food", 3.5);
  ILoFeature fmFeatures = new ConsLoFeature(appleBees, mtLoFeature);
  Place freshMeadows = new Place("Fresh Meadows", fmFeatures);
  IFeature citiField = new Venue("Citi Field", "stadium", 45000);
  IFeature q26 = new ShuttleBus("Q26", freshMeadows);
  IFeature q17 = new ShuttleBus("Q17", freshMeadows);
  ILoFeature flFeatures = new ConsLoFeature(citiField,
      new ConsLoFeature(q26, new ConsLoFeature(q17, mtLoFeature)));
  Place flushing = new Place("Flushing", flFeatures);
  IFeature wokWok = new Restaurant("Wok Wok", "asian cuisine", 4.9);
  ILoFeature ctFeatures = new ConsLoFeature(wokWok, mtLoFeature);
  Place chinaTown = new Place("ChinaTown", ctFeatures);
  IFeature sevenTrain = new ShuttleBus("7 Train", flushing);
  IFeature nTrain = new ShuttleBus("N Train", chinaTown);
  ILoFeature mta = new ConsLoFeature(sevenTrain, new ConsLoFeature(nTrain, mtLoFeature));
  Place nyc = new Place("New York City", mta);

  /*
   * Explanation for double-counting information
   * ---------------------------------------------- Whenever South Station is
   * referenced, it visits the NorthEnd twice: once from South Station itself, and
   * a second time from Harvard via ShuttleBus. This means that the
   * restaurantInfo, totalCapacity, and foodinessRating methods will double count
   * the features from North End.
   */
}