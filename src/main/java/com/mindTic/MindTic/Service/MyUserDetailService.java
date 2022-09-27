package com.mindTic.MindTic.Service;

import com.mindTic.MindTic.Entidades.Empleado;
import com.mindTic.MindTic.Entidades.MyUserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailService implements UserDetailsService {
    @Autowired
    Empleado empleado;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       /* try {
            System.out.println(username);
            Empleado user = empleado.getEmail();
            System.out.println(user);
            return new MyUserDetail(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UsernameNotFoundException(e.getMessage());
        }
*/
    return null;

    }
}
