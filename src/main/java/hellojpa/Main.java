package hellojpa;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hellojpa.entity.Member;
import hellojpa.entity.MemberType;
import hellojpa.entity.Team;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		try {
			Team team = new Team();
			team.setName("teamA");
			em.persist(team);

			Member member = new Member();
			// member.setId(100L);
			member.setName("member1");
			member.setMemberType(MemberType.USER);
			em.persist(member);
			
			//team.getMembers().add(member);
			member.setTeam(team);
			
			em.flush();
			em.clear();


			tx.commit();

		} catch (Exception e) {
			tx.rollback();

		} finally {
			em.close();
		}

		emf.close();
	}

}
