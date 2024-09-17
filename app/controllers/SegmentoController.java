package controllers;
import models.Segmento;
import play.mvc.*;
import io.ebean.*;

import java.util.List;

public class SegmentoController extends Controller {

    public Result getAllSegmentos() {
        List<Segmento> segmentos = Segmento.find.all();
        return ok(play.libs.Json.toJson(segmentos));
    }

    public Result createSegmento(Http.Request request) {
        Segmento segmento = play.libs.Json.fromJson(request.body().asJson(), Segmento.class);
        segmento.save();
        return ok(play.libs.Json.toJson(segmento));
    }

    public Result updateSegmento(Long id, Http.Request request) {
        Segmento segmento = Segmento.find.byId(id);
        if (segmento == null) return notFound("Segmento no encontrado");

        Segmento data = play.libs.Json.fromJson(request.body().asJson(), Segmento.class);
        segmento.numeroSegmento = data.numeroSegmento;
        segmento.direccion = data.direccion;
        segmento.longitud = data.longitud;
        segmento.update();
        return ok(play.libs.Json.toJson(segmento));
    }

    public Result deleteSegmento(Long id) {
        Segmento segmento = Segmento.find.byId(id);
        if (segmento == null) return notFound("Segmento no encontrado");

        segmento.delete();
        return ok("Segmento eliminado");
    }
}
