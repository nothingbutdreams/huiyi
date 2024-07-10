/* script.js */
new Vue({
    el: '#app',
    data: {
        reservationData: {
            meetingName: '1111111',
            remark: '111111',
            startTime: '11111111',
            endTime: '111111111',
            persName: '11111111111',
            mobile: '11111',
        }
    }/*,
    created() {
        this.fetchReservationData();
    },
    methods: {
        async fetchReservationData() {
            try {
                const response = await axios.get('https://your-backend-api.com/reservation');
                this.reservationData = response.data;
            } catch (error) {
                console.error('获取预约信息失败:', error);
                alert('获取预约信息失败，请重试.');
            }
        }
    }*/
});
