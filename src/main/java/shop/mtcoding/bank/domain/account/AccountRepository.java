package shop.mtcoding.bank.domain.account;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    // jpa query method
    // select * from account where number = :number
    // checkpoint! : 리펙토링 해야함!! (계좌 소유자 확인시에 쿼리가 두 번 나가기에 join fetch)
    Optional<Account> findByNumber(Long number);


    // jpa query method
    // select = from account where user5_id = :id
    List<Account> findByUser_Id(Long id);
}
