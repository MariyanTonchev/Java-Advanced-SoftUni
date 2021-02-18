package Google;

import java.util.List;

public class Person {
    private String name;
    private Company company;
    private final List<Pokemon> pokemon;
    private final List<Parents> parents;
    private final List<Children> children;
    private Car car;

    public Person(String name, Company company, List<Pokemon> pokemon, List<Parents> parents, List<Children> child, Car car) {
        this.name = name;
        this.company = company;
        this.pokemon = pokemon;
        this.parents = parents;
        this.children = child;
        this.car = car;
    }

    @Override
    public String toString() {
        StringBuilder output;
         if(car == null && company == null){
            output = new StringBuilder(name + '\n' +
                    "Company:\n" +
                    "Car:\n" +
                    "Pokemon:\n");
        } else if(company == null){
            output = new StringBuilder(name + '\n' +
                    "Company:\n" +
                    "Car:\n" + car + '\n' +
                    "Pokemon:\n");
        } else if(car == null){
            output = new StringBuilder(name + '\n' +
                    "Company:\n" + company + '\n' +
                    "Car:\n" +
                    "Pokemon:\n");
        } else {
             output = new StringBuilder(name + '\n' +
                     "Company:\n" + company + '\n' +
                     "Car:\n" + car + '\n' +
                     "Pokemon:\n");
         }
        for (Pokemon value : pokemon) {
            output.append(value.toString());
        }
        output.append("Parents:\n");
        for (Parents value : parents) {
            output.append(value.toString());
        }
        output.append("Children:\n");
        for (Children value : children) {
            output.append(value.toString());
        }
        return output.toString();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Pokemon> getPokemon() {
        return pokemon;
    }

    public List<Parents> getParents() {
        return parents;
    }

    public List<Children> getChildren() {
        return children;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
