/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemon;

import java.util.ArrayList;
import java.io.FileReader;
import java.io.Reader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
/**
 *
 * @author Jorge
 */
public class Gestorpokemon {

    private final ArrayList<Pokemon> arrayPokemon;

    public Gestorpokemon() {
        this.arrayPokemon = new ArrayList<Pokemon>();

    }

    public ArrayList<Pokemon> devuelvearray() {
        return arrayPokemon;
    }
    public void importarJSON(String nombreFichero) {
    try {
      JSONParser parser = new JSONParser();
      Reader reader = new FileReader(nombreFichero);
      Object jsonObj = parser.parse(reader);
      JSONObject jsonObject = (JSONObject) jsonObj;
      
      JSONArray manolito =(JSONArray) jsonObject.get("pokemon");
      manolito.forEach(entry ->{ 
      JSONObject objetopokemon = (JSONObject) entry;
      String nombre =(String) objetopokemon.get("name");
      String imagen =(String) objetopokemon.get("img");
      String peso =(String) objetopokemon.get("weight");
      Long id =(Long) objetopokemon.get("id");
      Pokemon noe = new Pokemon(nombre, imagen, peso, id);
      arrayPokemon.add(noe);
      });
      
      

      // Cerramos el lector
      reader.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}

