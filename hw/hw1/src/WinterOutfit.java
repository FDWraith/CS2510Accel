// to represent a winter outfit
interface IWinterOutfit { }

// to represent the innermost layer of an outfit
class BaseLayer implements IWinterOutfit {
  String name;
  
  BaseLayer( String name ) {
    this.name = name;
  }
}

// to represent additional layers on an outfit
class Covering implements IWinterOutfit {
  IWinterOutfit inner;
  String description;
 
  Covering( IWinterOutfit inner, String description ) {
    this.inner = inner;
    this.description = description;
  }
}

// to represent examples of winter outfits
class ExamplesWinterOutfit {
  
  IWinterOutfit leggings = new BaseLayer("leggings");
  IWinterOutfit sweatpants = new Covering(leggings, "sweatpants");
  IWinterOutfit skiPants = new Covering(sweatpants, "ski pants");
  IWinterOutfit boots = new Covering(skiPants, "boots");
  
  IWinterOutfit skiing = boots;
  
  IWinterOutfit shirt = new BaseLayer("shirt");
  IWinterOutfit vest = new Covering(shirt, "vest");
  IWinterOutfit suitJacket = new Covering(vest, "suit jacket");
  IWinterOutfit topCoat = new Covering(suitJacket, "top coat");
  IWinterOutfit scarf = new Covering(topCoat, "scarf");
  
  IWinterOutfit formalwear = scarf;
  
}