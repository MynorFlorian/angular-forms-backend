package com.example.demo.services;


import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
// import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.models.UserModel;
import com.example.demo.repositories.IUserRepositorie;

@Service
public class UserService implements IUserRepositorie{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public ArrayList<UserModel> findAll(){
        String sql = "select * from Usuario";
        ArrayList<UserModel> usuarios = new ArrayList<>(jdbcTemplate.query(sql, (rs, rowNum) -> {
            UserModel user = new UserModel();
            user.setId(rs.getLong("id"));
            user.setNombres(rs.getString("nombres"));
            user.setApellidos(rs.getString("apellidos"));
            user.setNickName(rs.getString("nick_name"));
            user.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
            user.setFechaCreacion(rs.getDate("fecha_creacion"));
            user.setFechaModificacion(rs.getDate("fecha_modificacion"));
            return user;
        }));
        return usuarios;
    }

    @Override
    public UserModel save(UserModel user){
        String sql = "CALL CRUD_USUARIOS(0, ?, ?, ?, ?, 3)";
        try {

            jdbcTemplate.update(sql, user.getNombres(), user.getApellidos(), 
            user.getNickName(), user.getFechaNacimiento());
            // Assume user gets an id on insert
            return user;    
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Optional<UserModel> findById(Long id){
        String sql = "CALL CRUD_USUARIOS(?, '', '', '', null, 2)";

        try {

            UserModel usuario = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
                UserModel user = new UserModel();
                user.setId(rs.getLong("id"));
                user.setNombres(rs.getString("nombres"));
                user.setApellidos(rs.getString("apellidos"));
                user.setNickName(rs.getString("nick_name"));
                user.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                user.setFechaCreacion(rs.getDate("fecha_creacion"));
                user.setFechaModificacion(rs.getDate("fecha_modificacion"));
                return user;
            }, new Object[]{id});
            

            return Optional.of(usuario);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public UserModel updateUserById(UserModel request, Long id){
        String sql = "CALL CRUD_USUARIOS(?, ?, ?, ?, ?, 4)";
        System.out.println(request.getNickName());
        try {
            jdbcTemplate.update(sql, id, request.getNombres(), request.getApellidos(), request.getNickName(), request.getFechaNacimiento());
            return request;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace(); 
            return null;
        }
    }


    /*
    @Override
    public ArrayList<UserModel> getUsers(){
        return (ArrayList<UserModel>) userRepo.findAll();
    }
    
    public UserModel saveUser(UserModel user ){
        return userRepo.save(user);
    }

    public Optional<UserModel> getUserById(Long id){
        return userRepo.findById(id);
    }

    public UserModel updateUserById(@RequestBody UserModel request, Long id){
        UserModel usuario = userRepo.findById(id).get();
        usuario.setNombres(request.getNombres());
        usuario.setApellidos(request.getApellidos());
        usuario.setNickName(request.getNickName());
        usuario.setFechaNacimiento(request.getFechaNacimiento());
        usuario.setFechaModificacion(request.getFechaModificacion());

        return usuario;
    }
    */
    // public Boolean deleteUser (Long id){
    //     try {
    //         userRepo.deleteById(id);
    //         return true;
    //     } catch (Exception e) {
    //         // TODO: handle exception
    //         return false;
    //     }
    // }

}

