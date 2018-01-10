// to represent a resource in the game
interface IResource { }


// to represent a coin
class Coin implements IResource {
  String material;
  int value;
  
  Coin( String material, int value ) {
    this.material = material;
    this.value = value;
  }
}

// to represent a victory token
class VictoryToken implements IResource {
  String type;
  int value;
  
  VictoryToken( String type, int value ) {
    this.type = type;
    this.value = value; 
  }
}

// to represent a card
class Card implements IResource { 
  String instructions;
  boolean grantsBonusAction;
  int value = 1;
  
  Card( String instructions, boolean grant ) {
    this.instructions = instructions;
    this.grantsBonusAction = grant;
  }
}

// to represent actions player can take
interface IAction { }

// to represent the player making a purchase
class Purchase implements IAction {
  int cost;
  IResource item;
  
  Purchase( int cost, IResource item ) {
    this.cost = cost;
    this.item = item;
  }
}

// to represent the player swapping his resource for something else
class Swap implements IAction {
  IResource consumed;
  IResource received;
  
  Swap( IResource consumed, IResource received ) {
    this.consumed = consumed; 
    this.received = received; 
  }
}


// to represent example game actions and resources
class ExamplesGame {
  IResource ducat = new Coin( "bronze", 5 );
  IResource fortress = new VictoryToken( "Fortress", 2);
  IResource mason = new Card("Play only if you have at least 3 victory points", true);
  IResource btc = new Coin( "digital", 15000 );
  IResource home = new VictoryToken( "Home", 2 );
  IResource deadEnd = new Card("Forfeit. You lose.", false);
  
  IAction purchase1 = new Purchase(5, ducat);
  IAction purchase2 = new Purchase(15000, btc);
  
  IAction swap1 = new Swap(fortress, home);
  IAction swap2 = new Swap(home, deadEnd);
}

