
new Vue({
    el: '#app',
    data: {
          trainingId: $('.trainingId').val(),
          studentId: $('.studentId').val(),
          selected: $('select').val(),
          date: '',
          content: '',
          intelligibility: '',
          detailIntelligibility: '',
          aboutInstructor: '',
          question: '',
          intelligibilityEnumString: '',
          aboutInstructorEnumString: ''
    },
    methods: {
        preview: function(event){
            $.ajax({
                url: '/student/searchDairyReport',
                data: {
                    day : this.selected,
                    trainingId : this.trainingId,
                    studentId : this.studentId
                },
                type: 'GET',
                dataType: 'json',
            })
            .done(function(data,textStatus,jqXHR){
                console.log("通信成功");
                this.date = data[0].date,
                this.content = data[0].content,
                this.intelligibility = data[0].intelligibility,
                this.detailIntelligibility = data[0].detailIntelligibility,
                this.aboutInstructor = data[0].aboutInstructor,
                this.question = data[0].question,
                this.intelligibilityEnumString = data[0].intelligibilityEnumString,
                this.aboutInstructorEnumString = data[0].aboutInstructorEnumString
            }.bind(this))
            .fail(function(jqXHR,textStatus,errorThrown){
                console.log("失敗しました");
            }.bind(this));
        }
    }
})