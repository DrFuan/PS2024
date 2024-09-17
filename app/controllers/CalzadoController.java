package app.controllers;

import app.models.Calzada;
import play.mvc.*;
import io.ebean.*;

import java.util.List;

public class CalzadaController extends Controller {

    public Result getAllCalzadas() {
        List<Calzada> calzadas = Calzada.find.all();
        return ok(play.libs.Json.toJson(calzadas));
    }

    public Result createCalzada(Http.Request request) {
        Calzada calzada = play.libs.Json.fromJson(request.body().asJson(), Calzada.class);
        calzada.save();
        return ok(play.libs.Json.toJson(calzada));
    }

    public Result updateCalzada(Long id, Http.Request request) {
        Calzada calzada = Calzada.find.byId(id);
        if (calzada == null) return notFound("Calzada no encontrada");

        Calzada data = play.libs.Json.fromJson(request.body().asJson(), Calzada.class);
        calzada.material = data.material;
        calzada.ancho = data.ancho;
        calzada.update();
        return ok(play.libs.Json.toJson(calzada));
    }

    public Result deleteCalzada(Long id) {
        Calzada calzada = Calzada.find.byId(id);
        if (calzada == null) return notFound("Calzada no encontrada");

        calzada.delete();
        return ok("Calzada eliminada");
    }
}
