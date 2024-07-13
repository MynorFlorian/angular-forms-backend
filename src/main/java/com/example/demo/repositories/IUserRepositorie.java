package com.example.demo.repositories;


import java.util.ArrayList;
import java.util.Optional;


import com.example.demo.models.UserModel;

public interface IUserRepositorie  {


    ArrayList<UserModel> findAll();
    UserModel save(UserModel user);
    Optional<UserModel> findById(Long id);
    UserModel updateUserById(UserModel request, Long id);
    
    // @Autowired
    // private JdbcTemplate jdbcTemplate;

    
    
    // public ArrayList<UserModel> findAll(){
    //     String sql = "CALL CRUD_USUARIOS(0, '', '', '', null, 1)";
    //     ArrayList<UserModel> usuarios = new ArrayList<>(jdbcTemplate.query(sql, (rs, rowNum) -> {
    //         UserModel user = new UserModel();
    //         user.setId(rs.getLong("id"));
    //         user.setNombres(rs.getString("nombres"));
    //         user.setApellidos(rs.getString("apellidos"));
    //         user.setNickName(rs.getString("nick_name"));
    //         user.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
    //         user.setFechaCreacion(rs.getDate("fecha_creacion"));
    //         user.setFechaModificacion(rs.getDate("fecha_modificacion"));
    //         return user;
    //     }));
    //     return usuarios;
    // }

    // public UserModel save(UserModel user){
    //     String sql = "CALL CRUD_USUARIOS(0, ?, ?, ?, ?, 3)";
    //     jdbcTemplate.update(sql, user.getNombres(), user.getApellidos(), user.getNickName(), user.getFechaNacimiento());
    //     // Assume user gets an id on insert
    //     return user;    
    // }

    // public Optional<UserModel> findById(Long id){
    //     String sql = "CALL CRUD_USUARIOS(?, '', '', '', null, 2)";

    //     try {

    //         UserModel usuario = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
    //             UserModel user = new UserModel();
    //             user.setId(rs.getLong("id"));
    //             user.setNombres(rs.getString("nombres"));
    //             user.setApellidos(rs.getString("apellidos"));
    //             user.setNickName(rs.getString("nick_name"));
    //             user.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
    //             user.setFechaCreacion(rs.getDate("fecha_creacion"));
    //             user.setFechaModificacion(rs.getDate("fecha_modificacion"));
    //             return user;
    //         }, new Object[]{id});
            

    //         return Optional.of(usuario);
    //     } catch (EmptyResultDataAccessException e) {
    //         return Optional.empty();
    //     }
    // }

    // public UserModel updateUserById(UserModel request, Long id){
    //     String sql = "CALL CRUD_USUARIOS(?, ?, ?, ?, ?, 4)";
    //     try {
    //         jdbcTemplate.update(sql, id, request.getNombres(), request.getApellidos(), request.getNickName(), request.getFechaNacimiento());
    //         return request;
    //     } catch (Exception e) {
    //         // TODO: handle exception
    //         return null;
    //     }
    // }

    // public Boolean deleteById(id){

    // }
}
