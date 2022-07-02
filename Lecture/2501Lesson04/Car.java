class Car
{
    /**
     * creates cars, with fuel
     * @param litersOfFuel how many liters of fuel
     * @throws NoGasException if there is little/no fuel
     */
    Car(final int litersOfFuel, final String model) throws NoGasException
    {
        if(litersOfFuel <= 1)
        {
            throw new NoGasException();
        }
        if(model == null || model.isBlank())
        {
            throw new IllegalCarModelException();
            throw new IllegalArgumentException("bad car model");
        }
    }
}
