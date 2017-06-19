<footer class="footer">
    <div class="container-fluid">
        <nav class="pull-left">
            <ul>
                <li>
                    <a href="http://www.nice.aeroport.fr/">
                        Nice
                    </a>
                </li>
            </ul>
        </nav>
        <div class="copyright pull-right">
            &copy;
            <script>document.write(new Date().getFullYear())</script>
            , made with <i class="fa fa-heart heart"></i> by MARTIN, JOYMANGUL, MOISSON
        </div>
    </div>
</footer>

</div>
</div>


</body>

<!-- Core JS Files -->
<%--<script src="/resources/assets/js/jquery-1.10.2.js" type="text/javascript"></script>--%>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="/resources/assets/js/bootstrap.min.js" type="text/javascript"></script>

<!-- Checkbox, Radio & Switch Plugins -->
<script src="/resources/assets/js/bootstrap-checkbox-radio.js"></script>

<!-- Charts Plugin -->
<script src="/resources/assets/js/chartist.min.js"></script>

<!-- Notifications Plugin -->
<script src="/resources/assets/js/bootstrap-notify.js"></script>

<!-- Paper Dashboard Core javascript and methods for Demo purpose -->
<script src="/resources/assets/js/paper-dashboard.js"></script>

<script>
    function error() {
        document.location.href="/";
        $.notify({
            icon: 'ti-na',
            message: "Erreur de connexion."

        }, {
            type: 'danger',
            timer: 2000
        });
    }
</script>

<script type="text/javascript">
    $(document).ready(function () {

        demo.initChartist();

/*
        $.notify({
            icon: 'ti-gift',
            message: "Welcome to <b>Paper Dashboard</b> - a beautiful Bootstrap freebie for your next project."

        }, {
            type: 'success',
            timer: 2000
        });
*/

        $( function() {
            $( "#accordion" ).accordion();
        } );

    });
</script>

</html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>