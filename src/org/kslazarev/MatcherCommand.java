package org.kslazarev;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class MatcherCommand {
    private final Map<String, StringBuilder> map;
    private final Pattern pattern;
    private final int keyGroupIndex;
    private final int valueGroupIndex;

    public MatcherCommand(String regExp, int keyGroupIndex, int valueGroupIndex) {
        this.map = new LinkedHashMap<String, StringBuilder>();
        this.pattern = Pattern.compile(regExp);
        this.keyGroupIndex = keyGroupIndex;
        this.valueGroupIndex = valueGroupIndex;
    }

    public void execute(String line) {
        Matcher matcher = pattern.matcher(line);
        matcher.find();

        String key = matcher.group(keyGroupIndex);
        String value = matcher.group(valueGroupIndex);

        if (map.get(key) == null) {
            map.put(key, new StringBuilder(value));
        } else {
            map.get(key).append(value);
        }
    }

    public Map<String, StringBuilder> getMap() {
        return map;
    }
}
