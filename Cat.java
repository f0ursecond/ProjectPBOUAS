class Cat extends Pet {

    public Cat(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println("Meow!");
        changeHappiness(5);
    }

    @Override
    void play() {
        System.out.println("Playing with yarn");
        setHappiness(getHappiness() + 15);
        setEnergy(getEnergy() - 10);
    }

    @Override
    String getSpecies() {
        return "Cat";
    }


    @Override
    public void timePasses() {
        changeHunger(10);
        changeHappiness(-5);
        changeEnergy(-2);
    }
}
