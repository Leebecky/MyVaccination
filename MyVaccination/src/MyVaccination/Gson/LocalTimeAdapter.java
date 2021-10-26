/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyVaccination.Gson;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.time.LocalTime;

 public class LocalTimeAdapter extends TypeAdapter<LocalTime> {

    @Override
    public void write(final JsonWriter jsonWriter, final LocalTime LocalTime) throws IOException {
        jsonWriter.value(LocalTime.toString());
    }

    @Override
    public LocalTime read(final JsonReader jsonReader) throws IOException {
        return LocalTime.parse(jsonReader.nextString());
    }
}
