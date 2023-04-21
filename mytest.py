from locust import HttpUser, task, between

class ReservationUser(HttpUser):
    wait_time = between(5, 15)

    @task
    def make_reservation(self):
        self.client.post("reservation", json={
            "name": "John Doe",
            "email": "johndoe@example.com",
            "phone": "123-456-7890",
            "date": "2023-04-01T19:00",
            "numGuests": 4
        })


