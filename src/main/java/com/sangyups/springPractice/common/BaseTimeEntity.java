package com.sangyups.springPractice.common;

import java.time.LocalDateTime;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * <p><code>MappedSuperclass</code>는 해당 클래스를 상속하는 JpaEntity 클래스들이
 * 필드들(e.g. CreatedDate, LastModifiedDate)을 자동으로 Column으로 인식하게 해준다.</p>
 *
 * <p><code>EntityListeners(AuditingEntityListner.class)</code>는
 * <code>BaseTimeEntity</code> 클래스에 JpaAuditing 기능을 포함시킨다.</p>
 */
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {

  @CreatedDate
  private LocalDateTime createdAt;

  @LastModifiedDate
  private LocalDateTime modifiedAt;
}
