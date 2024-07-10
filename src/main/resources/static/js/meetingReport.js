new Vue({
    el: '#app',
    data: {
        reservations: []
    },
    methods: {
        fetchReservations() {
            axios.get('/api/reservations')
                .then(response => {
                    this.reservations = response.data;
                })
                .catch(error => {
                    console.error("There was an error fetching the reservations!", error);
                });
        },
        refreshData() {
            this.fetchReservations();
        },
        addReservation() {
            // Logic to add a new reservation
        },
        deleteReservation(id) {
            axios.delete(`/api/reservations/${id}`)
                .then(response => {
                    this.fetchReservations();
                })
                .catch(error => {
                    console.error("There was an error deleting the reservation!", error);
                });
        }
    },
    mounted() {
        this.fetchReservations();
    }
});
