package controllers;

import app.models.Bordillo;
import play.mvc.*;
import io.ebean.*;

import java.util.List;

public class BordilloController extends Controller {

    public Result getAllBordillos() {
        List<Bordillo> bordillos = Bordillo.find.all();
        return ok(play.libs.Json.toJson(bordillos));
    }

    public Result createBordillo(Http.Request request) {
        Bordillo bordillo = play.libs.Json.fromJson(request.body().asJson(), Bordillo.class);
        bordillo.save();
        return ok(play.libs.Json.toJson(bordillo));
    }

    public Result updateBordillo(Long id, Http.Request request) {
        Bordillo bordillo = Bordillo.find.byId(id);
        if (bordillo == null) return notFound("Bordillo no encontrado");

        Bordillo data = play.libs.Json.fromJson(request.body().asJson(), Bordillo.class);
        bordillo.tipo = data.tipo;
        bordillo.altura = data.altura;
        bordillo.update();
        return ok(play.libs.Json.toJson(bordillo));
    }

    public Result deleteBordillo(Long id) {
        Bordillo bordillo = Bordillo.find.byId(id);
        if (bordillo == null) return notFound("Bordillo no encontrado");

        bordillo.delete();
        return ok("Bordillo eliminado");
    }
}
