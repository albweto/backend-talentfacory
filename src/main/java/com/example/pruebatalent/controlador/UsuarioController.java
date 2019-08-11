package com.example.pruebatalent.controlador;


import com.example.pruebatalent.modelo.Usuario;
import com.example.pruebatalent.service.UsuarioService;
import com.example.pruebatalent.util.ResResponse;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("account")
public class UsuarioController {

    @Autowired
    protected UsuarioService service;


    /**
     *
     */
    protected ObjectMapper mapper;


    /**
     *
     * @param userJson
     * @return
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    @RequestMapping(value = "/saveOrupdate", method = RequestMethod.POST)
    public ResResponse saveOrupdate(@RequestBody String userJson) throws JsonParseException, JsonMappingException, IOException
    {
        this.mapper = new ObjectMapper();
        Usuario usuario = this.mapper.readValue(userJson, Usuario.class);

        if (!this.validateUsuario(usuario)){
            return new ResResponse(HttpStatus.NOT_ACCEPTABLE.value(),"los campos obligatorios no estan diligenciados");
        }

        this.service.save(usuario);
        return  new ResResponse(HttpStatus.OK.value(), "Operacion Exitosa");
    }


    /**
     *
     * @return
     */
    @RequestMapping(value = "/getUSuarios" , method = RequestMethod.GET)
    public List<Usuario>  getUsuarios(){
       return  this.service.findAll();
    }


    /**
     *
     * @param userJson
     * @throws Exception
     */
    @RequestMapping(value = "/deleteusaer", method = RequestMethod.POST)
    public void deleteUsuario(@RequestBody String userJson) throws Exception {
    this.mapper = new ObjectMapper();

    Usuario usuario = this.mapper.readValue(userJson, Usuario.class);

    if (usuario.getId() <0){
        throw  new  Exception("El usuario es invalido");
    }

    this.service.deleteuser(usuario.getId());

    }

    /**
     *
     * @param principal
     * @return
     */
    @RequestMapping("/login")
    public Principal user(Principal principal) {
        return principal;
    }


    /**
     *
     * @param usuario
     * @return
     */
    public boolean validateUsuario(Usuario usuario){
        boolean isvalid = true;

        if (StringUtils.trimToNull( usuario.getNombre()) == null){
            isvalid = false;
        }
        if (StringUtils.trimToNull(usuario.getApellido())== null){
            isvalid = false;
        }
        if (StringUtils.trimToNull(usuario.getUsername()) == null){
            isvalid = false;
        }
        if (StringUtils.trimToNull(usuario.getPassword()) == null){
            isvalid = false;
        }

        if (StringUtils.trimToNull(usuario.getEmail()) == null){
            isvalid = false;
        }
        return  isvalid;

    }
}
