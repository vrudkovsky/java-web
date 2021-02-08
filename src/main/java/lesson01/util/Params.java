package lesson01.util;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class Params {

    public static Optional<Integer> toInt(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    public static Optional<String> getStrParam(String param, HttpServletRequest rq) {
        return Optional.ofNullable(rq.getParameter(param));
    }

    public static Optional<Integer> getIntParam(String param, HttpServletRequest rq) {
        return getStrParam(param, rq).flatMap(Params::toInt);
    }
}
