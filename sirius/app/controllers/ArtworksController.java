package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import configs.Global;
import models.entities.Artwork;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.ArtworkService;
import java.util.List;

public class ArtworksController extends Controller{

    ArtworkService artworkService = Global.getBean(ArtworkService.class);

    public Result getAll() {
        List<Artwork> artworkList = artworkService.list();
        return ok(Json.toJson(artworkList));
    }

    public Result get(int id) {
        try {
            Artwork artwork = artworkService.find(id);
            return ok(Json.toJson(artwork));
        } catch (Exception ex) {
            return ok(Json.toJson(new Artwork()));
        }
    }

    public Result create() {
        JsonNode jsonNode = request().body().asJson();
        Artwork entity = artworkService.save(jsonNode);
        return ok(Json.toJson(entity));
    }

    public Result update() {
        JsonNode jsonData = request().body().asJson();
        int id = jsonData.get("id").asInt();
        Artwork entity = artworkService.edit(id, jsonData);
        return ok(Json.toJson(entity));
    }

    public Result remove(int id){
        artworkService.remove(id);
        return ok();
    }
}
