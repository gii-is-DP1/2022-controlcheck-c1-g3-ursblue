package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RecoveryRoomRepository extends CrudRepository<RecoveryRoom, Integer> {
    List<RecoveryRoom> findAll();
    
    @Query("SELECT rt FROM RecoveryRoomType rt")
    List<RecoveryRoomType> findAllRecoveryRoomTypes();

    @Query("SELECT pt FROM RecoveryRoomType pt WHERE pt.name = :namep")
    RecoveryRoomType findRecoveryRoomTypeByName(@Param("namep") String name);

    Optional<RecoveryRoom> findById(int id);
    RecoveryRoom save(RecoveryRoom p);
    

    //RecoveryRoomType getRecoveryRoomType(String name);
}
