package com.example.geocodedemo;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;

@RestController
public class DirectionController {

    final String GOOGLE_MAPS_API = "https://maps.googleapis.com/maps/api/directions/json?";

    @RequestMapping(path = "/direction", method = RequestMethod.GET )
    public DirectionResult getDirection(@RequestParam String origin, @RequestParam String destination) throws IOException {
        DirectionApi requestTest = new DirectionApi(origin, destination);
        DirectionResult transitResult = requestTest.mode(TravelMode.TRANSIT).getResult();
        String savedUrl = requestTest.getUrl();
//        DirectionResult walkingResult = requestTest.mode(TravelMode.WALKING).getResult();
//        DirectionResult drivingResult = requestTest.mode(TravelMode.DRIVING).getResult();
//        DirectionResult bicyclingResult = requestTest.mode(TravelMode.BICYCLING).getResult();
        return transitResult;
    }
}