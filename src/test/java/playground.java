import com.yetnt.utils.builders.SimpleJSON;

enum HI {
    WHAT, TO, K
}

void main() throws Exception {
    SimpleJSON sim = new SimpleJSON();
    sim.set("key", "value");
    sim.set("key2", 10);
    sim.set("bl", 109420L);
    sim.set("ble", Map.of("10", 10L, "arr", new String[]{"a", "b"}));
    Map<HI, Object> map = new HashMap<>(Map.of(HI.WHAT, 100, HI.TO, Set.of("a", "b", 100)));
    map.put(HI.K, null);
    sim.set("lk", Arrays.asList(
            Map.of(),
            map,
            "c"
    ));

    IO.println(sim.copy().toString());
}
