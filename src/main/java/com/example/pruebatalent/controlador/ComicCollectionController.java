package com.example.pruebatalent.controlador;

import com.example.pruebatalent.modelo.CollecionComic;
import com.example.pruebatalent.service.CollecionComicService;
import com.example.pruebatalent.util.ResResponse;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class ComicCollectionController {

    @Autowired
    protected CollecionComicService comicService;

    protected ObjectMapper mapper;


    @RequestMapping(value = "/saveComic", method = RequestMethod.POST)
    public ResResponse saveOrupdate(@RequestBody String userJson) throws JsonParseException, JsonMappingException, IOException
    {
        this.mapper = new ObjectMapper();
        CollecionComic collecionComic = this.mapper.readValue(userJson, CollecionComic.class);

        if (!this.validateUsuario(collecionComic)){
            return new ResResponse(HttpStatus.NOT_ACCEPTABLE.value(),"los campos obligatorios no estan diligenciados");
        }

        this.comicService.save(collecionComic);
        return  new ResResponse(HttpStatus.OK.value(), "Operacion Exitosa");
    }


    @RequestMapping(value = "/getComic" , method = RequestMethod.GET)
    public List<CollecionComic> getComic(){
        return  this.comicService.findAll();
    }


    @RequestMapping(value = "/ComicByid", method = RequestMethod.GET)
    public void comicsByid(@RequestBody String userJson)throws Exception {
        this.mapper = new ObjectMapper();

        CollecionComic collecionComic = this.mapper.readValue(userJson, CollecionComic.class);

        this.comicService.findById(collecionComic.getUsuario().getId());
    }



    @RequestMapping(value = "/deleteComic", method = RequestMethod.POST)
    public void deleteComic(@RequestBody String userJson) throws Exception {
        this.mapper = new ObjectMapper();

        CollecionComic collecionComic = this.mapper.readValue(userJson, CollecionComic.class);

        if (collecionComic.getComic_id() <0){
            throw  new  Exception("El comic es invalido");
        }

        this.comicService.deleteComic(collecionComic.getComic_id());

    }


    public boolean validateUsuario(CollecionComic collecionComic){
        boolean isvalid = true;

        if (StringUtils.trimToNull( collecionComic.getNombre()) == null){
            isvalid = false;
        }
        if (StringUtils.trimToNull(collecionComic.getDescripcion())== null){
            isvalid = false;
        }
        if (StringUtils.trimToNull(collecionComic.getThumail()) == null){
            isvalid = false;
        }


        return  isvalid;

    }
}
