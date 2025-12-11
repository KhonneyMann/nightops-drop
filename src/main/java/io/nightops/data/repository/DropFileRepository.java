package io.nightops.data.repository;

import io.nightops.data.entity.DropFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DropFileRepository extends JpaRepository<DropFile, Long>{
    @Query("SELECT dropfile FROM DropFile as dropfile WHERE dropfile.shortCode=:shortCode")
    public DropFile findDropFileByShortCode(@Param("shortCode") String shortCode);
    
    @Query("SELECT SUM(dropfile.clickedCount) FROM DropFile as dropfile")
    public Long sumClickedCount();
    
    @Query("SELECT COUNT(dropfile.active) FROM DropFile as dropfile WHERE dropfile.active=false")
    public Long countPassiveDropFile();
}
