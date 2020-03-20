package io.namoosori.auction.user.store.jpo;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.namoosori.auction.user.entity.User;
import io.namoosori.auction.user.entity.UserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.lang.reflect.Type;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class UserJpo {

    @Id
    private String id;
    private String name;
    private String rolesJson;

    public UserJpo(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.rolesJson = (new Gson()).toJson(user.getRoles());
    }

    public User toDomain(){
        Type type = new TypeToken<List<UserRole>>(){}.getType();

        User user = new User(this.id, this.name);
        user.setRoles((new Gson()).fromJson(rolesJson, type));
        return user;
    }
}
