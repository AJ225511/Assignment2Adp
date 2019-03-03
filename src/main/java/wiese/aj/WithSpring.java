package wiese.aj;

import java.util.*;

public class WithSpring implements CollectionInterface {

    private ArrayList name;
    private Set id;
    private Map country;

    public WithSpring(){

        name = new ArrayList();
        id = new HashSet();
        country = new HashMap();
    }

    @Override
    public void list(String item) {

        name.add(item);

    }
    @Override
    public void set(String item){

        id.add(item);

    }
    @Override
    public void map(String key, String value){

        country.put(key,value);

    }

}


