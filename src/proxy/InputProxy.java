package proxy;

public class InputProxy implements Proxy {
    String[] tokens;

    @Override
    public boolean proxyTest(String code) {
        if (code.equals("")) return false;
        if (code.contains(",")) {
            tokens = code.split(",");
            int x = Integer.parseInt(tokens[0]);
            int y = Integer.parseInt(tokens[1]);
            return x >= 0 && x <= 2 && y >= 0 && y <= 2;
        } else return false;
    }

    @Override
    public String[] getCode() {
        return tokens;
    }
}
