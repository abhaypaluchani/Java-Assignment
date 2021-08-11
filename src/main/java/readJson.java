import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.HashMap;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class readJson {

	public static void main(String[] args) throws FileNotFoundException {
		JSONParser parser = new JSONParser();

		try {
			FileReader reader = new FileReader("D://jsonFile.json.txt");
			Object javaobj = parser.parse(reader);
			JSONObject jsonobj = (JSONObject) javaobj;
			JSONArray labsdata = (JSONArray) jsonobj.get("labs");
			JSONArray medidata = (JSONArray) jsonobj.get("medications");

			HashMap<String, String> labmap = new HashMap<>();
			HashMap<String, String> medimap = new HashMap<>();

			labmap = addlabdata(labsdata, labmap);
			for (Object m : medidata) {

				JSONObject mediobj = (JSONObject) m;

				JSONArray aceInhibitors = (JSONArray) mediobj.get("aceInhibitors");
				JSONArray antianginal = (JSONArray) mediobj.get("antianginal");
				JSONArray anticoagulants = (JSONArray) mediobj.get("anticoagulants");
				JSONArray betaBlocker = (JSONArray) mediobj.get("betaBlocker");
				JSONArray diuretic = (JSONArray) mediobj.get("diuretic");
				JSONArray mineral = (JSONArray) mediobj.get("mineral");

				medimap = addmedidata(aceInhibitors, medimap);
				medimap = addmedidata(antianginal, medimap);
				medimap = addmedidata(anticoagulants, medimap);
				medimap = addmedidata(betaBlocker, medimap);
				medimap = addmedidata(diuretic, medimap);
				medimap = addmedidata(mineral, medimap);
			}

			System.out.println("Medications Data: ");
			printdata(medimap);
			System.out.println();
			System.out.println("Lab Data: ");
			printdata(labmap);

		} catch (IOException e) {

			e.printStackTrace();
		} catch (ParseException e) {

			e.printStackTrace();
		}

	}

	static void printdata(HashMap<String, String> printhashmap) {
		HashMap<String, String> printmap;
		printmap = printhashmap;
		for (String name : printmap.keySet()) {
			String key = name.toString();
			String value = printmap.get(name).toString();
			System.out.println(key + ": " + value);
		}
	}

	static HashMap<String, String> addmedidata(JSONArray arr, HashMap<String, String> medimap) {
		JSONArray Arr = arr;

		for (Object k : Arr) {
			JSONObject temp1 = (JSONObject) k;
			String route = (String) temp1.get("route"), actroute = "PO";
			if (route.equals(actroute)) {
				String name = (String) temp1.get("name");
				String strength = (String) temp1.get("strength");
				medimap.put(name, strength);
			}
		}
		return medimap;
	}

	static HashMap<String, String> addlabdata(JSONArray arr, HashMap<String, String> labmap) {

		JSONArray Arr = arr;

		for (Object k : Arr) {
			JSONObject lab = (JSONObject) k;
			String S = (String) lab.get("time"), t = "Today";
			if (S.equals(t)) {
				String name = (String) lab.get("name");
				String location = (String) lab.get("location");
				labmap.put(name, location);

			}
		}
		return labmap;

	}

}
